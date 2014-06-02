psql -d test <<EOF
\x
SET ROLE bourribots;
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

DROP TABLE post_reblogs;
DROP TABLE post_likes;
DROP TABLE post_notes;
DROP TABLE post_tags;
DROP TABLE posts;
DROP TABLE users;
DROP TABLE tags;

CREATE TABLE users(
  id		int PRIMARY KEY,
  name		text
);

CREATE TABLE posts (
  id		int PRIMARY KEY,
  title		text,
  user_id 	int REFERENCES users(id)
);

CREATE TABLE tags (
  tag 		text PRIMARY KEY
);

CREATE TABLE post_notes (
  post_id	int REFERENCES posts(id),
  user_id	int REFERENCES users(id)
);

CREATE TABLE post_likes (
) INHERITS (post_notes);

CREATE TABLE post_reblogs (
) INHERITS (post_notes);

CREATE TABLE post_tags (
  post 		int REFERENCES posts(id),
  tag		text REFERENCES tags(tag)
);