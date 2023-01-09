/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaturelabs.manager.configuration;

import org.hibernate.boot.model.naming.*;
import org.hibernate.boot.model.source.spi.AttributePath;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.hibernate.internal.util.StringHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.regex.Pattern;

/**
 *
 * @author nirmal
 */
@Configuration
public class HibernateConfiguration {

    private static final Pattern REGX1 = Pattern.compile("([^_])([A-Z][a-z]+)");
    private static final Pattern REGX2 = Pattern.compile("([a-z0-9])([A-Z])");
    private static final String REPLACE = "$1_$2";

    private static String toSnakeCase(String input) {
        return REGX2.matcher(REGX1.matcher(input).replaceAll(REPLACE)).replaceAll(REPLACE).toLowerCase();
    }

    private static Identifier toSnakeCase(Identifier input) {
        return input == null ? null : new Identifier(toSnakeCase(input.getText()), input.isQuoted());
    }

    @Bean
    public ImplicitNamingStrategy implicitNamingStrategy() {
        return new ImplicitNamingStrategyJpaCompliantImpl() {

            @Override
            public Identifier determineJoinColumnName(ImplicitJoinColumnNameSource source) {
                return toIdentifier(source.getReferencedColumnName().getText(), source.getBuildingContext());
            }

            @Override
            protected String transformAttributePath(AttributePath attributePath) {
                return toSnakeCase(attributePath.getProperty());
            }

            @Override
            protected String transformEntityName(EntityNaming entityNaming) {
                // prefer the JPA entity name, if specified...
                if (StringHelper.isNotEmpty(entityNaming.getJpaEntityName())) {
                    return entityNaming.getJpaEntityName();
                }
                // otherwise, use the entity name converted to snake-case
                return toSnakeCase(StringHelper.unqualify(entityNaming.getEntityName()));
            }
        };
    }

    @Bean
    public PhysicalNamingStrategy physicalNamingStrategy() {
        return new PhysicalNamingStrategy() {
            @Override
            public Identifier toPhysicalCatalogName(Identifier name, JdbcEnvironment jdbcEnvironment) {
                return toSnakeCase(name);
            }

            @Override
            public Identifier toPhysicalSchemaName(Identifier name, JdbcEnvironment jdbcEnvironment) {
                return toSnakeCase(name);
            }

            @Override
            public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment jdbcEnvironment) {
                return toSnakeCase(name);
            }

            @Override
            public Identifier toPhysicalSequenceName(Identifier name, JdbcEnvironment jdbcEnvironment) {
                return toSnakeCase(name);
            }

            @Override
            public Identifier toPhysicalColumnName(Identifier name, JdbcEnvironment jdbcEnvironment) {
                return toSnakeCase(name);
            }
        };
    }
}
