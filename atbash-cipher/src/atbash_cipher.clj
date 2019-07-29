(ns atbash-cipher
  (:require [clojure.string :as s]
            [clojure.set :refer :all]))

(def alphabet "abcdefghijklmnopqrstuvwxyz")
(def punctuation (set ",|."))
(def whitespace (set " "))
(def removals (union punctuation whitespace))

(defn encode [word]
 (let [encoder (zipmap alphabet (reverse alphabet))]
   (->> word
      (s/lower-case)
      (remove removals)
      (map #(get encoder % %))
      (partition 5 5 "")
      (map #(apply str %))
      (s/join " "))))
