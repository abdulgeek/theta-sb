-- person
insert into person(id, map_data, name, email, password, active, role, attachment_list_data, creator, editor, created_by,
                   created, updated_by, updated)
values (0, '{}', 'Dev Test', 'duomail@mailinator.com', '$2a$12$mKW7whIhaeJqes14y7NeJuTyfANYSm7AUPXNjnlPhh660yEZ.Y7uO',
        true, 'Tenant', '[]', null,
        '{"id":1,"name":"Dev Test","email":"duomail@mailinator.com","role":"Administrator"}',
        'User test', '2021-09-20 11:31:07', 'User test', '2021-09-20 11:31:07');

-- shop
insert into shop (id, map_data, slug, name, creator, editor, created_by, created, updated_by, updated)
values (1, '{}', 'slug-001', 'Shop 001', null, null, 'User test', current_timestamp, 'User Test', current_timestamp);
insert into shop (id, map_data, slug, name, creator, editor, created_by, created, updated_by, updated)
values (2, '{}', 'slug-002', 'Shop 002', null, null, 'User test', current_timestamp, 'User Test', current_timestamp);
insert into shop (id, map_data, slug, name, creator, editor, created_by, created, updated_by, updated)
values (3, '{}', 'slug-003', 'Shop 003', null, null, 'User test', current_timestamp, 'User Test', current_timestamp);

-- product
insert into product (id, id_shop, slug, name, quantity)
values (1, 1, 'slug-001', 'Product 001', 1);
insert into product (id, id_shop, slug, name, quantity)
values (2, 1, 'slug-001', 'Product 002', 1);
insert into product (id, id_shop, slug, name, quantity)
values (3, 1, 'slug-001', 'Product 003', 1);