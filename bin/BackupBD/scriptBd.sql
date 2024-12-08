-- Table: public.vendedor

-- DROP TABLE IF EXISTS public.vendedor;

CREATE DATABASE domcolchao
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Portuguese_Brazil.1252'
    LC_CTYPE = 'Portuguese_Brazil.1252'
    LOCALE_PROVIDER = 'libc'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

CREATE TABLE IF NOT EXISTS public.cliente
(
    rua character varying(100) COLLATE pg_catalog."default" NOT NULL,
    numero integer NOT NULL,
    nome character varying COLLATE pg_catalog."default" NOT NULL,
    cpf character varying COLLATE pg_catalog."default" NOT NULL,
    cep character varying COLLATE pg_catalog."default" NOT NULL,
    telefone character varying COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT cliente_pkey PRIMARY KEY (cpf)
)

CREATE TABLE IF NOT EXISTS public.vendedor
(
    cpf character varying COLLATE pg_catalog."default" NOT NULL,
    nome character varying COLLATE pg_catalog."default" NOT NULL,
    telefone character varying COLLATE pg_catalog."default" NOT NULL,
    cep character varying COLLATE pg_catalog."default" NOT NULL,
    rua character varying COLLATE pg_catalog."default" NOT NULL,
    numero integer NOT NULL,
    ctps character varying COLLATE pg_catalog."default" NOT NULL,
    remuneracao double precision NOT NULL,
    data_nasc date NOT NULL,
    CONSTRAINT vendedor_pkey PRIMARY KEY (cpf)
)

CREATE TABLE IF NOT EXISTS public.produto
(
    nomeProd character varying COLLATE pg_catalog."default" NOT NULL,
    idProd integer NOT NULL,
    tamanhoProd character varying COLLATE pg_catalog."default" NOT NULL,
    densidadeProd character varying COLLATE pg_catalog."default" NOT NULL,
    materialProd character varying COLLATE pg_catalog."default" NOT NULL,
    precoProd double precision NOT NULL,
    CONSTRAINT produto_pkey PRIMARY KEY (idProd)
)