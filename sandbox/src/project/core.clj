(ns project.core
    (:import (com.tumblr.jumblr JumblrClient)))

(def client (new JumblrClient 
		 "WDXZgPZj1bkFbQIrEYNKMTy4UEjKYDxoVvQTKFUZj0LxHiQuJc"
		 "J1GgEilzQL794Tt5BS0gxv2wMkhiqm7rDEknbAmi1NjNC0IegJ"))

(def exblog (. client blogInfo "gamzee.tumblr.com"))

(defn get-name [] 
      (print 
	(.
	  exblog
	  getTitle)))

(defn -main [] (get-name))