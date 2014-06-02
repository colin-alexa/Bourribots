(ns project.core 
    (:require [project.db.korma :as db]
	      [project.db.core :as db-utils]
	      [project.jumblr.requests :as requests)
    (:use korma.db
	  korma.core))

(defn new-blog? [blog]
		(let [id (requests/blog-id blog)]
		     (not (some #(= % id)
			   (map :id db/blogs)))))

(defn -main [] (do (println (requests/get-hashtags-n-posts exblog 5))
		   (requests/n-posts-from-blog exblog 5)))