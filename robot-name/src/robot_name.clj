(ns robot-name
  (:require [clojure.string :refer [upper-case]]))

(def lower-alphabet "abcdefghijklmnopqrstuvwxyz")
(def upper-alphabet (upper-case lower-alphabet))

(defn- choice [coll]
  (first (shuffle (seq coll))))


(defrecord Robot [name])

(defn- random-name []
  (format "%s%s%d%d%d" 
    (choice upper-alphabet) 
    (choice upper-alphabet) 
    (rand-int 10) 
    (rand-int 10) 
    (rand-int 10)))

(defn robot [] 
  (atom (Robot. (random-name))))

(defn robot-name [robot]
    (:name @robot))

(defn reset-name [robot]
  (swap! robot assoc :name (random-name)))

