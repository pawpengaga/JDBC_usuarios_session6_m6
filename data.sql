CREATE TABLE public.usuarios (
    rut character varying(100) NOT NULL PRIMARY KEY,
    nombre character varying(250) NOT NULL,
    clave character varying(250) NOT NULL,
    correo character varying(250) NOT NULL,
    usuario character varying(250) NOT NULL
);

ALTER TABLE IF EXISTS public.usuarios
    OWNER to postgres;