INSERT INTO pg_catalog.pg_stat_activity (datid, datname, pid, leader_pid, usesysid, usename, application_name, client_addr, client_hostname, client_port, backend_start, xact_start, query_start, state_change, wait_event_type, wait_event, state, backend_xid, backend_xmin, query, backend_type) VALUES (null, null, 8484, null, 10, 'postgres', '', null, null, null, '2021-02-26 06:28:05.009413', null, null, null, 'Activity', 'LogicalLauncherMain', null, null, null, '', 'logical replication launcher');
INSERT INTO pg_catalog.pg_stat_activity (datid, datname, pid, leader_pid, usesysid, usename, application_name, client_addr, client_hostname, client_port, backend_start, xact_start, query_start, state_change, wait_event_type, wait_event, state, backend_xid, backend_xmin, query, backend_type) VALUES (null, null, 8456, null, null, null, '', null, null, null, '2021-02-26 06:28:05.002663', null, null, null, 'Activity', 'AutoVacuumMain', null, null, null, '', 'autovacuum launcher');
INSERT INTO pg_catalog.pg_stat_activity (datid, datname, pid, leader_pid, usesysid, usename, application_name, client_addr, client_hostname, client_port, backend_start, xact_start, query_start, state_change, wait_event_type, wait_event, state, backend_xid, backend_xmin, query, backend_type) VALUES (16808, 'sdb', 11252, null, 10, 'postgres', 'pgAdmin 4 - DB:sdb', '::1', null, 6907, '2021-02-26 11:44:34.064067', null, '2021-02-26 12:36:13.733820', '2021-02-26 12:36:13.749413', 'Client', 'ClientRead', 'idle', null, null, '/*pga4dash*/
SELECT ''session_stats'' AS chart_name, row_to_json(t) AS chart_data
FROM (SELECT
   (SELECT count(*) FROM pg_stat_activity WHERE datname = (SELECT datname FROM pg_database WHERE oid = 16808)) AS "Total",
   (SELECT count(*) FROM pg_stat_activity WHERE state = ''active'' AND datname = (SELECT datname FROM pg_database WHERE oid = 16808))  AS "Active",
   (SELECT count(*) FROM pg_stat_activity WHERE state = ''idle'' AND datname = (SELECT datname FROM pg_database WHERE oid = 16808))  AS "Idle"
) t
UNION ALL
SELECT ''tps_stats'' AS chart_name, row_to_json(t) AS chart_data
FROM (SELECT
   (SELECT sum(xact_commit) + sum(xact_rollback) FROM pg_stat_database WHERE datname = (SELECT datname FROM pg_database WHERE oid = 16808)) AS "Transactions",
   (SELECT sum(xact_commit) FROM pg_stat_database WHERE datname = (SELECT datname FROM pg_database WHERE oid = 16808)) AS "Commits",
   (SELECT sum(xact_rollback) FROM pg_stat_database WHERE datname = (SELECT datname FROM pg_database WHERE oid = 16808)) AS "Rollbacks"
) ', 'client backend');
INSERT INTO pg_catalog.pg_stat_activity (datid, datname, pid, leader_pid, usesysid, usename, application_name, client_addr, client_hostname, client_port, backend_start, xact_start, query_start, state_change, wait_event_type, wait_event, state, backend_xid, backend_xmin, query, backend_type) VALUES (16783, 'cars_db', 12868, null, 10, 'postgres', 'pgAdmin 4 - DB:cars_db', '::1', null, 9577, '2021-02-26 12:36:13.546624', null, '2021-02-26 12:36:19.840140', '2021-02-26 12:36:19.860297', 'Client', 'ClientRead', 'idle', null, null, '/*pga4dash*/
SELECT ''session_stats'' AS chart_name, row_to_json(t) AS chart_data
FROM (SELECT
   (SELECT count(*) FROM pg_stat_activity WHERE datname = (SELECT datname FROM pg_database WHERE oid = 16783)) AS "Total",
   (SELECT count(*) FROM pg_stat_activity WHERE state = ''active'' AND datname = (SELECT datname FROM pg_database WHERE oid = 16783))  AS "Active",
   (SELECT count(*) FROM pg_stat_activity WHERE state = ''idle'' AND datname = (SELECT datname FROM pg_database WHERE oid = 16783))  AS "Idle"
) t
UNION ALL
SELECT ''tps_stats'' AS chart_name, row_to_json(t) AS chart_data
FROM (SELECT
   (SELECT sum(xact_commit) + sum(xact_rollback) FROM pg_stat_database WHERE datname = (SELECT datname FROM pg_database WHERE oid = 16783)) AS "Transactions",
   (SELECT sum(xact_commit) FROM pg_stat_database WHERE datname = (SELECT datname FROM pg_database WHERE oid = 16783)) AS "Commits",
   (SELECT sum(xact_rollback) FROM pg_stat_database WHERE datname = (SELECT datname FROM pg_database WHERE oid = 16783)) AS "Rollbacks"
) ', 'client backend');
INSERT INTO pg_catalog.pg_stat_activity (datid, datname, pid, leader_pid, usesysid, usename, application_name, client_addr, client_hostname, client_port, backend_start, xact_start, query_start, state_change, wait_event_type, wait_event, state, backend_xid, backend_xmin, query, backend_type) VALUES (16808, 'sdb', 2284, null, 16470, 'toha', 'PostgreSQL JDBC Driver', '127.0.0.1', null, 3436, '2021-02-26 17:09:03.544293', null, '2021-02-26 17:09:14.858969', '2021-02-26 17:09:14.858976', 'Client', 'ClientRead', 'idle', null, null, 'COMMIT', 'client backend');
INSERT INTO pg_catalog.pg_stat_activity (datid, datname, pid, leader_pid, usesysid, usename, application_name, client_addr, client_hostname, client_port, backend_start, xact_start, query_start, state_change, wait_event_type, wait_event, state, backend_xid, backend_xmin, query, backend_type) VALUES (16808, 'sdb', 2000, null, 16470, 'toha', 'PostgreSQL JDBC Driver', '127.0.0.1', null, 3437, '2021-02-26 17:09:03.855980', null, '2021-02-26 17:09:03.887994', '2021-02-26 17:09:03.887999', 'Client', 'ClientRead', 'idle', null, null, 'SET application_name = ''PostgreSQL JDBC Driver''', 'client backend');
INSERT INTO pg_catalog.pg_stat_activity (datid, datname, pid, leader_pid, usesysid, usename, application_name, client_addr, client_hostname, client_port, backend_start, xact_start, query_start, state_change, wait_event_type, wait_event, state, backend_xid, backend_xmin, query, backend_type) VALUES (16808, 'sdb', 16760, null, 16470, 'toha', 'PostgreSQL JDBC Driver', '127.0.0.1', null, 3438, '2021-02-26 17:09:03.897204', null, '2021-02-26 17:09:03.929329', '2021-02-26 17:09:03.929344', 'Client', 'ClientRead', 'idle', null, null, 'SET application_name = ''PostgreSQL JDBC Driver''', 'client backend');
INSERT INTO pg_catalog.pg_stat_activity (datid, datname, pid, leader_pid, usesysid, usename, application_name, client_addr, client_hostname, client_port, backend_start, xact_start, query_start, state_change, wait_event_type, wait_event, state, backend_xid, backend_xmin, query, backend_type) VALUES (16808, 'sdb', 17020, null, 16470, 'toha', 'PostgreSQL JDBC Driver', '127.0.0.1', null, 3439, '2021-02-26 17:09:03.938873', null, '2021-02-26 17:09:03.971069', '2021-02-26 17:09:03.971087', 'Client', 'ClientRead', 'idle', null, null, 'SET application_name = ''PostgreSQL JDBC Driver''', 'client backend');
INSERT INTO pg_catalog.pg_stat_activity (datid, datname, pid, leader_pid, usesysid, usename, application_name, client_addr, client_hostname, client_port, backend_start, xact_start, query_start, state_change, wait_event_type, wait_event, state, backend_xid, backend_xmin, query, backend_type) VALUES (16808, 'sdb', 10784, null, 16470, 'toha', 'PostgreSQL JDBC Driver', '127.0.0.1', null, 3440, '2021-02-26 17:09:03.980855', null, '2021-02-26 17:09:04.012698', '2021-02-26 17:09:04.012706', 'Client', 'ClientRead', 'idle', null, null, 'SET application_name = ''PostgreSQL JDBC Driver''', 'client backend');
INSERT INTO pg_catalog.pg_stat_activity (datid, datname, pid, leader_pid, usesysid, usename, application_name, client_addr, client_hostname, client_port, backend_start, xact_start, query_start, state_change, wait_event_type, wait_event, state, backend_xid, backend_xmin, query, backend_type) VALUES (16808, 'sdb', 16708, null, 16470, 'toha', 'PostgreSQL JDBC Driver', '127.0.0.1', null, 3441, '2021-02-26 17:09:04.024639', null, '2021-02-26 17:09:04.056261', '2021-02-26 17:09:04.056267', 'Client', 'ClientRead', 'idle', null, null, 'SET application_name = ''PostgreSQL JDBC Driver''', 'client backend');
INSERT INTO pg_catalog.pg_stat_activity (datid, datname, pid, leader_pid, usesysid, usename, application_name, client_addr, client_hostname, client_port, backend_start, xact_start, query_start, state_change, wait_event_type, wait_event, state, backend_xid, backend_xmin, query, backend_type) VALUES (16808, 'sdb', 10756, null, 16470, 'toha', 'PostgreSQL JDBC Driver', '127.0.0.1', null, 3442, '2021-02-26 17:09:04.065851', null, '2021-02-26 17:09:04.097479', '2021-02-26 17:09:04.097490', 'Client', 'ClientRead', 'idle', null, null, 'SET application_name = ''PostgreSQL JDBC Driver''', 'client backend');
INSERT INTO pg_catalog.pg_stat_activity (datid, datname, pid, leader_pid, usesysid, usename, application_name, client_addr, client_hostname, client_port, backend_start, xact_start, query_start, state_change, wait_event_type, wait_event, state, backend_xid, backend_xmin, query, backend_type) VALUES (16808, 'sdb', 13168, null, 16470, 'toha', 'PostgreSQL JDBC Driver', '127.0.0.1', null, 3443, '2021-02-26 17:09:04.107057', null, '2021-02-26 17:09:04.138903', '2021-02-26 17:09:04.138911', 'Client', 'ClientRead', 'idle', null, null, 'SET application_name = ''PostgreSQL JDBC Driver''', 'client backend');
INSERT INTO pg_catalog.pg_stat_activity (datid, datname, pid, leader_pid, usesysid, usename, application_name, client_addr, client_hostname, client_port, backend_start, xact_start, query_start, state_change, wait_event_type, wait_event, state, backend_xid, backend_xmin, query, backend_type) VALUES (16808, 'sdb', 17156, null, 16470, 'toha', 'PostgreSQL JDBC Driver', '127.0.0.1', null, 3444, '2021-02-26 17:09:04.148075', null, '2021-02-26 17:09:04.179841', '2021-02-26 17:09:04.179847', 'Client', 'ClientRead', 'idle', null, null, 'SET application_name = ''PostgreSQL JDBC Driver''', 'client backend');
INSERT INTO pg_catalog.pg_stat_activity (datid, datname, pid, leader_pid, usesysid, usename, application_name, client_addr, client_hostname, client_port, backend_start, xact_start, query_start, state_change, wait_event_type, wait_event, state, backend_xid, backend_xmin, query, backend_type) VALUES (13442, 'postgres', 1576, null, 10, 'postgres', 'pgAdmin 4 - DB:postgres', '::1', null, 6474, '2021-02-26 11:41:16.578589', null, '2021-02-26 12:36:13.432185', '2021-02-26 12:36:13.432664', 'Client', 'ClientRead', 'idle', null, null, '
SELECT
    db.oid as did, db.datname, db.datallowconn,
    pg_encoding_to_char(db.encoding) AS serverencoding,
    has_database_privilege(db.oid, ''CREATE'') as cancreate, datlastsysoid
FROM
    pg_database db
WHERE db.oid = 16783', 'client backend');
INSERT INTO pg_catalog.pg_stat_activity (datid, datname, pid, leader_pid, usesysid, usename, application_name, client_addr, client_hostname, client_port, backend_start, xact_start, query_start, state_change, wait_event_type, wait_event, state, backend_xid, backend_xmin, query, backend_type) VALUES (16394, 'test', 13968, null, 10, 'postgres', 'pgAdmin 4 - DB:test', '::1', null, 6494, '2021-02-26 11:41:17.091975', null, '2021-02-26 11:41:33.436942', '2021-02-26 11:41:33.457126', 'Client', 'ClientRead', 'idle', null, null, '/*pga4dash*/
SELECT ''session_stats'' AS chart_name, row_to_json(t) AS chart_data
FROM (SELECT
   (SELECT count(*) FROM pg_stat_activity WHERE datname = (SELECT datname FROM pg_database WHERE oid = 16394)) AS "Total",
   (SELECT count(*) FROM pg_stat_activity WHERE state = ''active'' AND datname = (SELECT datname FROM pg_database WHERE oid = 16394))  AS "Active",
   (SELECT count(*) FROM pg_stat_activity WHERE state = ''idle'' AND datname = (SELECT datname FROM pg_database WHERE oid = 16394))  AS "Idle"
) t
UNION ALL
SELECT ''tps_stats'' AS chart_name, row_to_json(t) AS chart_data
FROM (SELECT
   (SELECT sum(xact_commit) + sum(xact_rollback) FROM pg_stat_database WHERE datname = (SELECT datname FROM pg_database WHERE oid = 16394)) AS "Transactions",
   (SELECT sum(xact_commit) FROM pg_stat_database WHERE datname = (SELECT datname FROM pg_database WHERE oid = 16394)) AS "Commits",
   (SELECT sum(xact_rollback) FROM pg_stat_database WHERE datname = (SELECT datname FROM pg_database WHERE oid = 16394)) AS "Rollbacks"
) ', 'client backend');
INSERT INTO pg_catalog.pg_stat_activity (datid, datname, pid, leader_pid, usesysid, usename, application_name, client_addr, client_hostname, client_port, backend_start, xact_start, query_start, state_change, wait_event_type, wait_event, state, backend_xid, backend_xmin, query, backend_type) VALUES (16469, 'car_shop', 14924, null, 10, 'postgres', 'pgAdmin 4 - DB:car_shop', '::1', null, 6637, '2021-02-26 11:42:11.332015', null, '2021-02-26 11:42:22.617885', '2021-02-26 11:42:22.637832', 'Client', 'ClientRead', 'idle', null, null, '/*pga4dash*/
SELECT ''session_stats'' AS chart_name, row_to_json(t) AS chart_data
FROM (SELECT
   (SELECT count(*) FROM pg_stat_activity WHERE datname = (SELECT datname FROM pg_database WHERE oid = 16469)) AS "Total",
   (SELECT count(*) FROM pg_stat_activity WHERE state = ''active'' AND datname = (SELECT datname FROM pg_database WHERE oid = 16469))  AS "Active",
   (SELECT count(*) FROM pg_stat_activity WHERE state = ''idle'' AND datname = (SELECT datname FROM pg_database WHERE oid = 16469))  AS "Idle"
) t
UNION ALL
SELECT ''tps_stats'' AS chart_name, row_to_json(t) AS chart_data
FROM (SELECT
   (SELECT sum(xact_commit) + sum(xact_rollback) FROM pg_stat_database WHERE datname = (SELECT datname FROM pg_database WHERE oid = 16469)) AS "Transactions",
   (SELECT sum(xact_commit) FROM pg_stat_database WHERE datname = (SELECT datname FROM pg_database WHERE oid = 16469)) AS "Commits",
   (SELECT sum(xact_rollback) FROM pg_stat_database WHERE datname = (SELECT datname FROM pg_database WHERE oid = 16469)) AS "Rollbacks"
) ', 'client backend');
INSERT INTO pg_catalog.pg_stat_activity (datid, datname, pid, leader_pid, usesysid, usename, application_name, client_addr, client_hostname, client_port, backend_start, xact_start, query_start, state_change, wait_event_type, wait_event, state, backend_xid, backend_xmin, query, backend_type) VALUES (16435, 'test2', 14872, null, 10, 'postgres', 'pgAdmin 4 - DB:test2', '::1', null, 6498, '2021-02-26 11:41:17.105786', null, '2021-02-26 11:41:17.316968', '2021-02-26 11:41:17.318715', 'Client', 'ClientRead', 'idle', null, null, '
        SELECT
            oid as id, rolname as name, rolsuper as is_superuser,
            CASE WHEN rolsuper THEN true ELSE rolcreaterole END as
            can_create_role,
            CASE WHEN rolsuper THEN true ELSE rolcreatedb END as can_create_db
        FROM
            pg_catalog.pg_roles
        WHERE
            rolname = current_user', 'client backend');
INSERT INTO pg_catalog.pg_stat_activity (datid, datname, pid, leader_pid, usesysid, usename, application_name, client_addr, client_hostname, client_port, backend_start, xact_start, query_start, state_change, wait_event_type, wait_event, state, backend_xid, backend_xmin, query, backend_type) VALUES (16808, 'sdb', 16368, null, 16470, 'toha', 'PostgreSQL JDBC Driver', '127.0.0.1', null, 3445, '2021-02-26 17:09:04.188801', null, '2021-02-26 17:09:04.220852', '2021-02-26 17:09:04.220860', 'Client', 'ClientRead', 'idle', null, null, 'SET application_name = ''PostgreSQL JDBC Driver''', 'client backend');
INSERT INTO pg_catalog.pg_stat_activity (datid, datname, pid, leader_pid, usesysid, usename, application_name, client_addr, client_hostname, client_port, backend_start, xact_start, query_start, state_change, wait_event_type, wait_event, state, backend_xid, backend_xmin, query, backend_type) VALUES (16808, 'sdb', 14164, null, 16470, 'toha', 'PostgreSQL JDBC Driver', '127.0.0.1', null, 3866, '2021-02-26 17:21:14.859407', '2021-02-26 17:21:14.905503', '2021-02-26 17:21:14.907074', '2021-02-26 17:21:14.907075', null, null, 'active', null, 2335, 'SELECT t.* FROM pg_catalog.pg_stat_activity t', 'client backend');
INSERT INTO pg_catalog.pg_stat_activity (datid, datname, pid, leader_pid, usesysid, usename, application_name, client_addr, client_hostname, client_port, backend_start, xact_start, query_start, state_change, wait_event_type, wait_event, state, backend_xid, backend_xmin, query, backend_type) VALUES (null, null, 8432, null, null, null, '', null, null, null, '2021-02-26 06:28:04.994686', null, null, null, 'Activity', 'BgWriterHibernate', null, null, null, '', 'background writer');
INSERT INTO pg_catalog.pg_stat_activity (datid, datname, pid, leader_pid, usesysid, usename, application_name, client_addr, client_hostname, client_port, backend_start, xact_start, query_start, state_change, wait_event_type, wait_event, state, backend_xid, backend_xmin, query, backend_type) VALUES (null, null, 8416, null, null, null, '', null, null, null, '2021-02-26 06:28:04.994259', null, null, null, 'Activity', 'CheckpointerMain', null, null, null, '', 'checkpointer');
INSERT INTO pg_catalog.pg_stat_activity (datid, datname, pid, leader_pid, usesysid, usename, application_name, client_addr, client_hostname, client_port, backend_start, xact_start, query_start, state_change, wait_event_type, wait_event, state, backend_xid, backend_xmin, query, backend_type) VALUES (null, null, 8440, null, null, null, '', null, null, null, '2021-02-26 06:28:05.000703', null, null, null, 'Activity', 'WalWriterMain', null, null, null, '', 'walwriter');