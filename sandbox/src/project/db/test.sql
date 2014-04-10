psql <<EOF
\x
DROP TABLE test1;
CREATE TABLE test1 (
  lastname	varchar(255),
  firstname	varchar(255),
  age		int,
  party		varchar(5)
);

INSERT INTO test1 	(lastname, firstname, age, party)
VALUES			('Greener', 'Ima', 20, 'Ind'),
			('Person', 'Imaginary', 111, 'Green');
EOF
