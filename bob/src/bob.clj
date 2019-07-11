(ns bob
  (:require [clojure.string :refer [upper-case trim]]
            [clojure.set :refer [union]]))

(def digits (set "1234567890"))
(def punc (set ",.!#^)({}[]"))

(defn without [removals s ]
    (apply str (remove removals s)))

(defn clean [s]
  (->> s
       (without (union digits punc))
       (trim)))

(defn yelling? [s]
  (and 
    (= s (upper-case s))
    (> (count s) 1)))

(defn question? [s]
  (= (last s) \?))

(defn response-for [s]
  (let [cleaned (clean s)]
    (cond
      (empty? (trim s)) "Fine. Be that way!"
      (and 
        (yelling? cleaned) 
        (not (question? cleaned))) "Whoa, chill out!"
      (and 
        (question? cleaned)
        (not (yelling? cleaned))) "Sure."
      (and 
        (yelling? cleaned)
        (question? cleaned)) "Calm down, I know what I'm doing!"
      :else "Whatever.")))
