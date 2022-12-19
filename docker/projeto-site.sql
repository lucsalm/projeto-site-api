CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE table IF NOT EXISTS public.users (
                user_id VARCHAR NOT NULL DEFAULT uuid_generate_v4(),
                email VARCHAR NOT NULL,
                username VARCHAR NOT NULL,
                password BYTEA NOT NULL,
                telephone VARCHAR NOT NULL,
                cep VARCHAR NOT NULL,
                address VARCHAR NOT NULL,
                address_number INTEGER NOT NULL,
                CONSTRAINT users_pk PRIMARY KEY (user_id)
);


CREATE table IF NOT EXISTS public.products (
                product_id VARCHAR NOT NULL DEFAULT uuid_generate_v4(),
                name VARCHAR NOT NULL,
                price NUMERIC(8,2) NOT NULL,
                CONSTRAINT products_pk PRIMARY KEY (product_id)
);


CREATE table IF NOT EXISTS public.images (
                image_id VARCHAR NOT NULL DEFAULT uuid_generate_v4(),
                image_product_id VARCHAR NOT NULL,
                image VARCHAR NOT NULL,
                CONSTRAINT images_pk PRIMARY KEY (image_id)
);


CREATE table IF NOT EXISTS public.orders (
                order_id VARCHAR NOT NULL DEFAULT uuid_generate_v4(),
                order_user_id VARCHAR NOT NULL,
                product_id VARCHAR NOT NULL,
                active_order BOOLEAN NOT NULL,
                last_alter_date TIMESTAMP NOT null,
                quantity INTEGER NOT NULL,
                CONSTRAINT orders_pk PRIMARY KEY (order_id, order_user_id)
);




ALTER TABLE public.orders DROP CONSTRAINT IF EXISTS users_orders_fk;
ALTER table public.orders ADD CONSTRAINT users_orders_fk
FOREIGN KEY (order_user_id)
REFERENCES public.users (user_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.orders DROP CONSTRAINT IF EXISTS products_orders_fk;
ALTER TABLE public.orders ADD CONSTRAINT products_orders_fk
FOREIGN KEY (product_id)
REFERENCES public.products (product_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER table public.images DROP CONSTRAINT IF EXISTS products_images_fk;
ALTER table public.images ADD CONSTRAINT products_images_fk
FOREIGN KEY (image_product_id)
REFERENCES public.products (product_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;
