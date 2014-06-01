(ns project.db.core
  (:require [lobos.config :as my-lobos])
  (:use lobos.core
	lobos.connectivity
	lobos.schema))

(defn test-table-create []
      (do 
	(create
	  (table :users
		 (integer :id :auto-inc :primary-key)
		 (varchar :name 127)))
	(create
	  (table :posts
		 (integer :user_id)
		 (varchar :title 255)
		 (text    :url)
		 (integer :post_id)))
	(drop (table :users))
	(drop (table :posts))))

(defn -main [] (test-table-create))