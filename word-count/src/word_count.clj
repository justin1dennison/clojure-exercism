(ns word-count
  (:require [clojure.string :as str]))

(def punctuation ",!?@#$%&^*():")

(defn- strip [chars coll]
  (apply str (remove (set chars) coll)))

(def ^:private remove-punctuation (partial strip punctuation))

(defn- flip-split [pattern s]
  (str/split s pattern))

(defn- normalize-spacing [s]
  (str/replace s #"\s{2,}" " "))

(defn word-count [s]
  (->> s
       str/lower-case
       remove-punctuation
       normalize-spacing
       (flip-split #" ")
       frequencies))




