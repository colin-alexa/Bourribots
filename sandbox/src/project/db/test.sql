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
DROP TABLE blogs;
DROP TABLE users;


CREATE TABLE users (
  id		SERIAL PRIMARY KEY,
  name		varchar(255),
  url		text
);

CREATE TABLE posts (
  id		int PRIMARY KEY,
  user_id 	int REFERENCES users(id)
);

CREATE TABLE blogs (
  name		text,
  user_id	int REFERENCES users(id)
);

CREATE TABLE post_tags (
  post 		int REFERENCES posts(id),
  tag		text
);