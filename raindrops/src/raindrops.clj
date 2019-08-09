(ns raindrops
  (:require [clojure.string :as s]))

(defn divides? [k n] (zero? (mod n k)))

(defn number->sound [factor sound]
  (fn [n]
    (when (divides? factor n)
      sound)))

(def pling (number->sound 3 "Pling"))
(def plang (number->sound 5 "Plang"))
(def plong (number->sound 7 "Plong"))


(defn convert [n]
  (as-> n k 
    ((juxt pling plang plong) k)
    (filter some? k)
    (if (empty? k)
      (str n)
      (s/join k))))
