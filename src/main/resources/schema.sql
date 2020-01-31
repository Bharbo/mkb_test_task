CREATE TABLE CAR
(
  id IDENTITY primary key,
  brand VARCHAR(150),
  model VARCHAR(200),
  power DOUBLE,
  year_of_issue YEAR
);

CREATE TABLE AIRPLANE
(
  id IDENTITY primary key,
  brand VARCHAR(150),
  model VARCHAR(200),
  manufacturer VARCHAR(500),
  year_of_issue YEAR,
  fuelCapacity INT,
  seats INT
);

CREATE TABLE PRICE
(
    id IDENTITY primary key,
    value DECIMAL (15,2),
    date DATE,
    collateral_id INT,
    collateral_type VARCHAR(150)
);

