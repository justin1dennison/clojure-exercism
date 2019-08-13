(ns trinary
  (:require [clojure.set :refer [difference]]))

(def valid-digits (set "0123456789"))

(defn- char->int [c]
  (- (int c) 48))

(defn- convert [power amount]
  (* (char->int amount) (Math/pow 3 power)))

(defn- valid? [n]
  (->> valid-digits
       (difference (set n))
       (count)
       zero?))

(defn to-decimal [n]
  (if (valid? n)
    (->> n
         (reverse)
         (map-indexed convert)
         (reduce +)
         int)
    0))

