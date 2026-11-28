-- Site pilote
INSERT INTO office (id, name, address) VALUES (RANDOM_UUID(),'Paris République','Place de la République, 75011 Paris');

-- 8 zones (100 postes au total)
INSERT INTO workspace (id, office_id, code, name, capacity) VALUES (RANDOM_UUID(), (SELECT id FROM office WHERE name = 'Paris République'), 'AT', 'Atlas', 20),
(RANDOM_UUID(), (SELECT id FROM office WHERE name = 'Paris République'), 'BO', 'Boréal', 20),
(RANDOM_UUID(), (SELECT id FROM office WHERE name = 'Paris République'), 'CA', 'Calypso', 15),
(RANDOM_UUID(), (SELECT id FROM office WHERE name = 'Paris République'), 'DE', 'Delta', 15),
(RANDOM_UUID(), (SELECT id FROM office WHERE name = 'Paris République'), 'EC', 'Echo', 10),
(RANDOM_UUID(), (SELECT id FROM office WHERE name = 'Paris République'), 'FJ', 'Fjord', 10),
(RANDOM_UUID(), (SELECT id FROM office WHERE name = 'Paris République'), 'GA', 'Gala', 5),
(RANDOM_UUID(), (SELECT id FROM office WHERE name = 'Paris République'), 'HE', 'Hélios', 5);

-- ATLAS : 20 postes (AT-01 à AT-20)
INSERT INTO computer (id, workspace_id, name) SELECT RANDOM_UUID(),w.id,'AT-' || LPAD(CAST(n AS VARCHAR), 2, '0')FROM workspace w CROSS JOIN SYSTEM_RANGE(1, 20) numbers(n) WHERE w.code = 'AT';
-- BOREAL : 20 postes (BO-01 à BO-20)
INSERT INTO computer (id, workspace_id, name) SELECT RANDOM_UUID(),w.id,'BO-' || LPAD(CAST(n AS VARCHAR), 2, '0')FROM workspace w CROSS JOIN SYSTEM_RANGE(1, 20) numbers(n) WHERE w.code = 'BO';
-- CALYPSO : 15 postes (CA-01 à CA-15)
INSERT INTO computer (id, workspace_id, name) SELECT RANDOM_UUID(),w.id,'CA-' || LPAD(CAST(n AS VARCHAR), 2, '0')FROM workspace w CROSS JOIN SYSTEM_RANGE(1, 15) numbers(n) WHERE w.code = 'CA';
-- DELTA : 15 postes (DE-01 à DE-15)
INSERT INTO computer (id, workspace_id, name) SELECT RANDOM_UUID(),w.id,'DE-' || LPAD(CAST(n AS VARCHAR), 2, '0')FROM workspace w CROSS JOIN SYSTEM_RANGE(1, 15) numbers(n) WHERE w.code = 'DE';
-- ECHO : 10 postes (EC-01 à EC-10)
INSERT INTO computer (id, workspace_id, name) SELECT RANDOM_UUID(),w.id,'EC-' || LPAD(CAST(n AS VARCHAR), 2, '0')FROM workspace w CROSS JOIN SYSTEM_RANGE(1, 10) numbers(n) WHERE w.code = 'EC';
-- FJORD : 10 postes (FJ-01 à FJ-10)
INSERT INTO computer (id, workspace_id, name) SELECT RANDOM_UUID(),w.id,'FJ-' || LPAD(CAST(n AS VARCHAR), 2, '0')FROM workspace w CROSS JOIN SYSTEM_RANGE(1, 10) numbers(n) WHERE w.code = 'FJ';
-- GALA : 5 postes (GA-01 à GA-05)
INSERT INTO computer (id, workspace_id, name) SELECT RANDOM_UUID(),w.id,'GA-' || LPAD(CAST(n AS VARCHAR), 2, '0')FROM workspace w CROSS JOIN SYSTEM_RANGE(1, 5) numbers(n) WHERE w.code = 'GA';
-- HELIOS : 5 postes (HE-01 à HE-05)
INSERT INTO computer (id, workspace_id, name) SELECT RANDOM_UUID(),w.id,'HE-' || LPAD(CAST(n AS VARCHAR), 2, '0')FROM workspace w CROSS JOIN SYSTEM_RANGE(1, 5) numbers(n) WHERE w.code = 'HE';

-- Utilisateurs (user user et admin admin)
INSERT INTO internal_user (id, username, password, role) VALUES
(RANDOM_UUID(), 'user', '$2a$10$X/2PacH/zD5MmVg1MZTBuOcq/5HEMgIEgNybSZs0DmFAJoj/IIfwm', 'ROLE_USER'),
(RANDOM_UUID(), 'admin', '$2a$10$/vwCDOtQ62FG68kkrZHU.eQbVn8c6Dw/3FsyQCoVSjeD9u21Wa.zq', 'ROLE_ADMIN');