BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "users" (
	"id"	INTEGER,
	"name"	TEXT NOT NULL,
	"email"	TEXT NOT NULL UNIQUE,
	"password"	TEXT NOT NULL,
	"role"	TEXT NOT NULL CHECK("role" IN ('user', 'admin')),
	PRIMARY KEY("id" AUTOINCREMENT)
);
CREATE TABLE IF NOT EXISTS "category" (
	"id"	INTEGER,
	"name"	TEXT NOT NULL,
	PRIMARY KEY("id" AUTOINCREMENT)
);
CREATE TABLE IF NOT EXISTS "product" (
	"id"	INTEGER,
	"name"	TEXT NOT NULL,
	"price"	REAL NOT NULL,
	"path"	TEXT,
	"stock"	INT NOT NULL,
	"category"	INT,
	PRIMARY KEY("id" AUTOINCREMENT),
	FOREIGN KEY("category") REFERENCES "category"("id")
);
CREATE TABLE IF NOT EXISTS "transactions" (
	"id"	INTEGER,
	"invoice"	TEXT NOT NULL,
	"productid"	INTEGER NOT NULL,
	"quantity"	INTEGER NOT NULL,
	"total"	REAL NOT NULL,
	"change"	REAL NOT NULL,
	"timestamp"	DATETIME DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY("id" AUTOINCREMENT),
	FOREIGN KEY("productid") REFERENCES "product"("id")
);
INSERT INTO "users" VALUES (1,'user','user@gmail.com','$2a$10$fk4MudjULGulvp.NclY9HeGvsV6aMtGrWYbT3UTH6g/vfRSS3ZcYK','user');
INSERT INTO "users" VALUES (2,'admin','admin@gmail.com','$2a$10$fjfSSJSvKgCOCpPc8Yl5Fu3isLPSaj24Km86MT1g2Jm96mcu89SF2','admin');
INSERT INTO "category" VALUES (1,'Makanans');
INSERT INTO "category" VALUES (2,'Minuman');
INSERT INTO "product" VALUES (1,'Kepiting Saus Padang',12000.0,'/image-1.jpg',100,0);
INSERT INTO "product" VALUES (2,'Nasi Kuning',15000.0,'/image-2.jpg',100,0);
INSERT INTO "product" VALUES (3,'Bakso',10000.0,'/image-3.jpg',100,0);
INSERT INTO "product" VALUES (4,'Sate Ayam',14000.0,'/image-4.jpg',100,0);
INSERT INTO "product" VALUES (5,'Chicken Katsu',16000.0,'/image-5.jpg',100,0);
INSERT INTO "product" VALUES (6,'Kepiting Saus Padang',12000.0,'/image-1.jpg',100,0);
INSERT INTO "product" VALUES (7,'Nasi Kuning',15000.0,'/image-2.jpg',100,0);
INSERT INTO "product" VALUES (8,'Bakso',10000.0,'/image-3.jpg',100,0);
INSERT INTO "product" VALUES (9,'Sate Ayam',14000.0,'/image-4.jpg',100,0);
INSERT INTO "transactions" VALUES (1,'inv-20942679',3,2,20000.0,0.0,'2024-05-24 20:45:10');
INSERT INTO "transactions" VALUES (2,'inv-27749044',1,2,24000.0,6000.0,'2024-05-25 07:05:56');
COMMIT;
