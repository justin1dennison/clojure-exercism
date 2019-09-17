(ns anagram
  (:require [clojure.set :as set]
            [clojure.string :as s]))

(defn anagram? [target source]
  (let [target (s/lower-case target)
        source (s/lower-case source)]
    (and
     (not= target source)
     (= (frequencies target) (frequencies source)))))

(defn anagrams-for [word prospect-list]
  (->> prospect-list
       (filter (partial anagram? (s/lower-case word)))))

