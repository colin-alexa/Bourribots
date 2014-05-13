(ns lobos.config
  (:require [project.db.config :as db-config])
  (:use lobos.connectivity))

(def db
  {:classname "org.postgresql.Driver"
   :subprotocol "postgresql"
   :user db-config/user
   :password db-config/pw
   :subname "//localhost:5432/bourribots"})

(open-global db) 
