INSERT INTO pg_catalog.pg_rules (schemaname, tablename, rulename, definition) VALUES ('pg_catalog', 'pg_settings', 'pg_settings_u', 'CREATE RULE pg_settings_u AS
    ON UPDATE TO pg_catalog.pg_settings
   WHERE (new.name = old.name) DO  SELECT set_config(old.name, new.setting, false) AS set_config;');
INSERT INTO pg_catalog.pg_rules (schemaname, tablename, rulename, definition) VALUES ('pg_catalog', 'pg_settings', 'pg_settings_n', 'CREATE RULE pg_settings_n AS
    ON UPDATE TO pg_catalog.pg_settings DO INSTEAD NOTHING;');