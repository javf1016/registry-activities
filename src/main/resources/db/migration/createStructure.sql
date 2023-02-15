-- Database: microservices_test

-- DROP DATABASE IF EXISTS microservices_test;

CREATE DATABASE microservices_test
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Spanish_Colombia.1252'
    LC_CTYPE = 'Spanish_Colombia.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

-- Table: public.employees

-- DROP TABLE IF EXISTS public.employees;

CREATE TABLE IF NOT EXISTS public.employees
(
    employee_id integer NOT NULL,
    last_name character varying(255) COLLATE pg_catalog."default",
    name character varying(255) COLLATE pg_catalog."default",
    "position" character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT employees_pkey PRIMARY KEY (employee_id)
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.employees
    OWNER to postgres;


-- Table: public.activities

-- DROP TABLE IF EXISTS public.activities;

CREATE TABLE IF NOT EXISTS public.activities
(
    activity_id integer NOT NULL,
    date_estimated_time_execution timestamp(6) without time zone,
    day_delay integer NOT NULL,
    description character varying(255) COLLATE pg_catalog."default",
    name character varying(255) COLLATE pg_catalog."default",
    status character varying(255) COLLATE pg_catalog."default",
    employee_id integer,
    CONSTRAINT activities_pkey PRIMARY KEY (activity_id),
    CONSTRAINT fkolqfxude3ki5reapiyat5fc98 FOREIGN KEY (employee_id)
    REFERENCES public.employees (employee_id) MATCH SIMPLE
                                               ON UPDATE NO ACTION
                                               ON DELETE NO ACTION
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.activities
    OWNER to postgres;

-- Table: public.assigments

-- DROP TABLE IF EXISTS public.assigments;

CREATE TABLE IF NOT EXISTS public.assigments
(
    assigment_id integer NOT NULL,
    time_assignment timestamp(6) without time zone,
    activity_id integer,
    employee_id integer,
    CONSTRAINT assigments_pkey PRIMARY KEY (assigment_id),
    CONSTRAINT fk3nrwbfskiu1b34bcdd5ndvwug FOREIGN KEY (employee_id)
    REFERENCES public.employees (employee_id) MATCH SIMPLE
                                 ON UPDATE NO ACTION
                                 ON DELETE NO ACTION,
    CONSTRAINT fkfo2l2r7mqvxulwocirsjmq2s5 FOREIGN KEY (activity_id)
    REFERENCES public.activities (activity_id) MATCH SIMPLE
                                 ON UPDATE NO ACTION
                                 ON DELETE NO ACTION
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.assigments
    OWNER to postgres;