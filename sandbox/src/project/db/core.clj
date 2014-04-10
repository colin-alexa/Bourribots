(ns project.db.core
    (:require [project.db.config :as config])
    (:use korma.db))

(defdb bourribots (postgres {:db "bourribots" :host "localhost" :port 5432 :user config/user :password config/pw}))

