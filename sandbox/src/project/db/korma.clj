(ns project.db.korma
    (:require [project.db.config :as config])
    (:use korma.db
	  korma.core))

(defdb bourribots (postgres {:db "test" 
			     :host "localhost" 
			     :port 5432 
			     :user config/user 
			     :password config/pw 
			     ;this next one is a test, feel free to take it out
			     :rando "some weird guy at this party idk"}))

(defentity users
	   (entity-fields :id :name :url))

(defentity posts
	   (entity-fields :id :title :user_id)
	   (has-one users))

(defentity hashtags
	   (entity-fields :tag))

(defentity post_tags
	   (entity-fields :post_id :tag))

(def blogs (select users))

(def posts (select posts))