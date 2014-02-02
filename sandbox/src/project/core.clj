(ns project.core
    (:import (com.tumblr.jumblr JumblrClient)))

(def client (new JumblrClient
		 "WDXZgPZj1bkFbQIrEYNKMTy4UEjKYDxoVvQTKFUZj0LxHiQuJc"
		 "J1GgEilzQL794Tt5BS0gxv2wMkhiqm7rDEknbAmi1NjNC0IegJ"))

(def exblog (. client blogInfo "gamzee.tumblr.com"))

(defn last-post [blog]
      (first (. blog posts {"offset" 10000})))

(defn text-post? [post] (instance? com.tumblr.jumblr.types.TextPost post))

(defn method-test []
      (print 
	(.
	  exblog
	  posts)))

(defn nph [blog n]
      (loop [offset 0
	     coll []]
	    (if (< (- n (+ offset 20)) 1)
	        (concat coll (. blog posts {"offset" offset "limit" (- n offset)}))
	        (recur (+ offset 20) (concat coll (. blog posts {"offset" offset})))))) 

(defn n-posts [blog n]
      (if (<= n 20)
	  (. blog posts {"limit" n})
	  (nph blog n)))

(defn -main [] (count (nph exblog 53)))