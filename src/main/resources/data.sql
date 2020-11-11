DROP TABLE IF EXISTS continent;
DROP TABLE IF EXISTS country;
DROP TABLE IF EXISTS state;
DROP TABLE IF EXISTS airport;
 
CREATE TABLE continent (
  uuid varchar(255) NOT NULL,
  abbr VARCHAR(5) NOT NULL,
  name VARCHAR(100) NOT NULL
);

CREATE TABLE country (
  uuid varchar(255) NOT NULL,
  iso VARCHAR(5) NOT NULL,
  name VARCHAR(100) NOT NULL
);


CREATE TABLE state (
  uuid varchar(255) NOT NULL,
  abbr VARCHAR(5) NOT NULL,
  name VARCHAR(250) NOT NULL,
  region VARCHAR(50) DEFAULT NULL,
  district_type VARCHAR(50) DEFAULT NULL,
  country VARCHAR(5) NOT NULL  
);

CREATE TABLE airport (
  uuid varchar(255) NOT NULL,
  name VARCHAR(250) NOT NULL,
  city VARCHAR(250) NOT NULL,
  iata VARCHAR(50) DEFAULT NULL,
  full_location VARCHAR(250) DEFAULT NULL,
  type VARCHAR(50) NOT NULL,
  latitude VARCHAR(50) NOT NULL,
  longitude VARCHAR(50) NOT NULL,
  elevation VARCHAR(50) NOT NULL,
  website VARCHAR(250) DEFAULT NULL,
  country VARCHAR(5) NOT NULL,
  state VARCHAR(5) NOT NULL,
  continent VARCHAR(5) NOT NULL  
);
 
 
INSERT INTO continent (uuid, abbr, name) VALUES
  (uuid(), 'EU', 'Eurpoe'),
  (uuid(), 'SA', 'South America'),
  (uuid(), 'NA', 'North America');
  
INSERT INTO country (uuid, iso, name) VALUES
  (uuid(), 'AF', 'Afghanistan'),
  (uuid(), 'AX', 'Aland Islands'),
  (uuid(), 'AL', 'Albania'),
  (uuid(), 'GB', 'United Kingdom'),
  (uuid(), 'IN','India');
  
INSERT INTO state (uuid, abbr, name, region, district_type, country) VALUES
  (uuid(), 'AN', 'Andaman and Nicobar Islands', NULL, 'State','IN'),
  (uuid(), 'AP', 'Andhra Pradesh', NULL, 'State','IN'),
  (uuid(), 'AR', 'Arunachal Pradesh', NULL, 'State','IN'),
  (uuid(), 'AS', 'Assam', NULL, 'State','IN'),
  (uuid(), 'LN', 'London', NULL, 'County','GB');


INSERT INTO airport (uuid, name, city, iata, full_location, type, latitude, longitude, elevation, website, country, state, continent) VALUES
  (uuid(), 'London - All Airports','London','LON','London, London, United Kingdom', 'group','51.507351','-0.127758','65',null,'GB','LN', 'EU');
 