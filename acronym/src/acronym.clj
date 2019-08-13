(ns acronym
  (:require [clojure.string :as s]))

(defn uppercase? [c]
  (Character/isUpperCase c))

(defn- select [word]
  (let [remaining-letters (if (every? uppercase? (rest word)) [] (rest word))]
    (->> (filter uppercase? remaining-letters)
         (concat [(first word)])
         s/join)))

(defn acronym [phrase]
  (->> (s/split phrase #"\s|-|:")
       (map select)
       s/join
       s/upper-case))

