(ns project.db.core
    (:require [project.db.config :as config])
    (:use korma.db
	  korma.core
	  lobos.core))

(defdb bourribots (postgres {:db "bourribots" :host "localhost" :port 5432 :user config/user :password config/pw :rando "some weird guy at this party idk"}))

(defentity test1)

(defn select-test [] (print
		 (select test1
			 (fields :lastname :firstname :age :party))))