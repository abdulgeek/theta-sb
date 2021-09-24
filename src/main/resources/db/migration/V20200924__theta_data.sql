insert into person(id, map_data, name, email, password, active, role, attachment_list_data, creator, editor, created_by,
                   created, updated_by, updated)
values (1, '{}', 'Dev Test', 'duomail@mailinator.com', '$2a$12$mKW7whIhaeJqes14y7NeJuTyfANYSm7AUPXNjnlPhh660yEZ.Y7uO',
        true, 'Tenant', '[]', null,
        '{"id":1,"name":"Dev Test","email":"duomail@mailinator.com","role":"Administrator"}',
        'User test', '2021-09-20 11:31:07', 'User test', '2021-09-20 11:31:07');

commit;