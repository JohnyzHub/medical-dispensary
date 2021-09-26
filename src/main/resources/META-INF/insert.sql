insert into medication(id, name) values(1, 'Vicodin');
insert into medication(id, name) values(2, 'Simvastatin');
insert into medication(id, name) values(3, 'Lisinopril');
insert into medication(id, name) values(4, 'Levothyroxine');
insert into medication(id, name) values(5, 'Azithromycin');
insert into medication(id, name) values(6, 'Metformin');
insert into medication(id, name) values(7, 'Lipitor');
select setval('med_seq', coalesce(max(id), 0) + 1, false) from medication;
alter table medication alter column id set default nextval('med_seq');