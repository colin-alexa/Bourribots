(ns project.core
    (:import (com.tumblr.jumblr JumblrClient)))

(def client (new JumblrClient 
		 "WDXZgPZj1bkFbQIrEYNKMTy4UEjKYDxoVvQTKFUZj0LxHiQuJc"
		 "J1GgEilzQL794Tt5BS0gxv2wMkhiqm7rDEknbAmi1NjNC0IegJ"))

(def exblog (. client blogInfo "gamzee.tumblr.com"))

(defn last-post [blog]
      (first (. blog posts)))

(defn text-post? [post] (instance? com.tumblr.jumblr.types.TextPost post))

(defn method-test [] 
      (print 
	(.
	  exblog
	  posts)))

(defn -main [] (text-post? (last-post exblog)))