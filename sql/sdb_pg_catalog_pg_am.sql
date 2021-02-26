INSERT INTO pg_catalog.pg_am (oid, amname, amhandler, amtype) VALUES (2, 'heap', heap_tableam_handler, 't');
INSERT INTO pg_catalog.pg_am (oid, amname, amhandler, amtype) VALUES (403, 'btree', bthandler, 'i');
INSERT INTO pg_catalog.pg_am (oid, amname, amhandler, amtype) VALUES (405, 'hash', hashhandler, 'i');
INSERT INTO pg_catalog.pg_am (oid, amname, amhandler, amtype) VALUES (783, 'gist', gisthandler, 'i');
INSERT INTO pg_catalog.pg_am (oid, amname, amhandler, amtype) VALUES (2742, 'gin', ginhandler, 'i');
INSERT INTO pg_catalog.pg_am (oid, amname, amhandler, amtype) VALUES (4000, 'spgist', spghandler, 'i');
INSERT INTO pg_catalog.pg_am (oid, amname, amhandler, amtype) VALUES (3580, 'brin', brinhandler, 'i');