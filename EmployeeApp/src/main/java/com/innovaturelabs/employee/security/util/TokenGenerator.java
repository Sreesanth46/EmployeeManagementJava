package com.innovaturelabs.employee.security.util;

import java.security.SecureRandom;
import java.time.Duration;
import java.util.Base64;
import java.util.regex.Pattern;

import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.util.Assert;

/**
 * Utility class for generating and verifying secure tokens. Uses AES 256 bit
 * encryption.
 *
 * @author nirmal
 */
public class TokenGenerator {

    /**
     * Class used for returning the generated token.
     */
    public static final class Token {

        /**
         * The generated token.
         */
        public final String value;
        /**
         * The time stamp in milliseconds used in the token.
         */
        public final long time;
        /**
         * The expiry time in milliseconds of the token.
         */
        public final long expiry;

        private Token(String value, long time, long expiry) {
            this.value = value;
            this.time = time;
            this.expiry = expiry;
        }
    }

    /**
     * Class used for returning verification status of a token.
     */
    public static final class Status {

        /**
         * The data embedded in the token.
         */
        public final String data;
        /**
         * The time stamp in milliseconds used in the token.
         */
        public final long time;
        /**
         * The expiry time in milliseconds of the token.
         */
        public final long expiry;

        private Status(String data, long time, long expiry) {
            this.data = data;
            this.time = time;
            this.expiry = expiry;
        }
    }

    private static final String SEPARATOR = "#";

    private static final Pattern PURPOSE_PATTERN = Pattern.compile("[a-zA-Z0-9_]+");

    private static final Base64.Encoder ENCODER = Base64.getEncoder();
    private static final Base64.Decoder DECODER = Base64.getDecoder();

    private static String encode(String input) {
        return ENCODER.encodeToString(input.getBytes());
    }

    private static String decode(String input) throws IllegalArgumentException {
        return new String(DECODER.decode(input));
    }

    private final SecureRandom random = new SecureRandom();

    private final TextEncryptor textEncryptor;

    /**
     * Creates an instance of TokenGenerator with the given password and salt.
     * The password cannot be null and must be exactly 16 ASCII characters. The
     * salt also cannot be null and must be exactly 16 digit hexadecimal value.
     *
     * @param password the password to be used for encryption
     * @param salt the salt to be used for encryption
     *
     * @throws IllegalArgumentException if there is a problem with the given
     * password or salt
     */
    public TokenGenerator(String password, String salt) throws IllegalArgumentException {
        Assert.notNull(password, "password cannot be null");
        Assert.isTrue(password.matches("[\\x00-\\x7F]{16}"), "password must be exactly 16 ASCII characters");
        Assert.notNull(salt, "salt cannot be null");
        Assert.isTrue(salt.matches("[0-9A-Fa-f]{16}"), "salt must be exactly 16 digit hexadecimal");
        textEncryptor = Encryptors.text(password, salt);
    }

    /**
     * Create a token with the given purpose, data, expiry. The token will have
     * an embedded timestamp only if the expiry is not {@code null} and is &gt;
     * 0 milliseconds. The purpose should only contain the characters 'a-Z',
     * 'A-Z', '0-9' and '_'.
     *
     * @param purpose the tag for identifying the purpose of the token - the
     * same value has to be passed for verifying the token
     * @param data the data to be embedded in the token - cannot be null
     * @param expiry the time in seconds for the expiry of the token - if this
     * value is not {@code null} and is &gt; 0 milliseconds, a timestamp will be
     * embedded in the token which will be used during the verification of the
     * token
     *
     * @return the generated token and its related information
     *
     * @throws IllegalArgumentException if there is a problem with the given
     * purpose or data
     */
    public Token create(String purpose, String data, Duration expiry) throws IllegalArgumentException {
        Assert.notNull(purpose, "purpose cannot be null");
        Assert.isTrue(PURPOSE_PATTERN.matcher(purpose).matches(), "purpose should only contain the characters 'a-Z', 'A-Z', '0-9' and '_'");
        Assert.notNull(data, "data cannot be null");

        int r;
        long t, e;

        if (expiry != null && expiry.toMillis() > 0) {
            t = System.currentTimeMillis();
            e = expiry.toMillis();
            r = random.nextInt();
        } else {
            e = 0;
            t = 0;
            r = 0;
        }

        String token = purpose + SEPARATOR + encode(data) + SEPARATOR + t + SEPARATOR + e + SEPARATOR + r;

        return new Token(textEncryptor.encrypt(token), t, t + e);
    }

    /**
     * Verifies the given token. The purpose should match the value given during
     * the creation of the token. The token will be checked for expiration if
     * the token was created with an expiry value &gt; 0. The separator used
     * will be {@link #SEPARATOR}.
     *
     * @param purpose the tag for identifying the purpose of the token - should
     * match the value given during the creation of the token
     * @param token the token to be verified
     *
     * @return the verification status
     *
     * @see #verify(String, String, boolean)
     */
    public Status verify(String purpose, String token) throws InvalidTokenException, TokenExpiredException {
        return verify(purpose, token, true);
    }

    /**
     * Verifies the given token. The purpose should match the value given during
     * the creation of the token. The token will be checked for expiration only
     * if the token was created with an expiry value &gt; 0 and checkExpiry is
     * {@code true}.
     *
     * @param purpose the tag for identifying the purpose of the token - should
     * match the value given during the creation of the token
     * @param token the token to be verified
     * @param checkExpiry flag specifying whether the token should be checked
     * for expiry even if it contains an embedded timestamp
     *
     * @return the verification status
     */
    public Status verify(String purpose, String token, boolean checkExpiry) throws InvalidTokenException, TokenExpiredException {
        String value;
        try {
            value = textEncryptor.decrypt(token);
        } catch (RuntimeException e) {
            throw new InvalidTokenException("Token cannot be decoded", e);
        }

        String[] parts = value.split(SEPARATOR);
        if (parts.length != 5 || !parts[0].equals(purpose)) {
            throw new InvalidTokenException("Token content is invalid");
        }

        long keyTime;
        long expiry;
        try {
            keyTime = Long.parseLong(parts[2]);
            expiry = Long.parseLong(parts[3]);
        } catch (NumberFormatException e) {
            throw new InvalidTokenException("Token content is invalid", e);
        }

        if (checkExpiry && expiry > 0) {
            long currentTime = System.currentTimeMillis();
            long timeDiff = currentTime - keyTime;

            if (timeDiff >= expiry) {
                throw new TokenExpiredException("Token is expired");
            }
        }

        String data;
        try {
            data = decode(parts[1]);
        } catch (IllegalArgumentException e) {
            throw new InvalidTokenException("Token content is invalid", e);
        }

        return new Status(decode(parts[1]), keyTime, keyTime + expiry);
    }
}
