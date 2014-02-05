(ns project.core
    (:import (com.tumblr.jumblr JumblrClient)))

(def client (new JumblrClient
		 "WDXZgPZj1bkFbQIrEYNKMTy4UEjKYDxoVvQTKFUZj0LxHiQuJc"  ; Key
		 "J1GgEilzQL794Tt5BS0gxv2wMkhiqm7rDEknbAmi1NjNC0IegJ")); Consumer secret

(def exblog (. client blogInfo "gamzee.tumblr.com"))

(defn last-post [blog]
      (first (. blog posts {"offset" 10000})))
      
(defn first-post [blog]
      (last (. blog posts {})))

(defn text-post? [post] (instance? com.tumblr.jumblr.types.TextPost post))

(defn method-test []
      (print 
	(.
	  exblog
	  posts)))

(defn n-posts ([blog n]
		(loop [offset 0
		       coll []]
		      (if (< (- n (+ offset 20)) 1)
			  (concat coll (. blog posts {"offset" offset "limit" (- n offset)}))
			  (recur (+ offset 20) (concat coll (. blog posts {"offset" offset}))))))
      
	      ([blog n opts]
		(loop [offset 0
		       coll []]
		      (if (< (- n (+ offset 20)) 1)
			  (concat coll (. blog posts (merge opts {"offset" offset "limit" (- n offset)})))
			  (recur (+ offset 20) (concat coll (. blog posts {"offset" offset})))))))

; TODO: 
;  posts by date
;  n-posts with offset

(defn get-notes-n-posts [blog n]
      (let [posts (n-posts blog n {"notes_info" true})]
	    (map vector
		 posts
		 (map #(. % getNotes) posts))))

; Need a "get random" blogs. How to do this?
; Other needs:
; -get blogs with "x" tag
; -get blogs/posts in x-y time period
; -get with x# of tags
; -get with x# of likes/reblogs/notes
	   

(defn -main [] (get-notes-n-posts exblog 5))
