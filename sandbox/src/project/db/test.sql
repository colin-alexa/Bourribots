psql -d test <<EOF
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

DROP TABLE post_tags;
DROP TABLE posts;
DROP TABLE users;


CREATE TABLE users (
  id		PRIMARY KEY,
  name		text
);

CREATE TABLE posts (
  id		int PRIMARY KEY,
  title		text,
  user_id 	int REFERENCES users(id)
);

CREATE TABLE post_tags (
  post 		int REFERENCES posts(id),
  tag		text
);