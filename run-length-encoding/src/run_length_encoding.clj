(ns run-length-encoding
  (:require [clojure.string :refer [join]]))

(defn- one? [n]
  (= n 1))

(defn- encode-part [part]
  (let [n (count part)
        letter (first part)]
    (str (when-not (one? n) n) letter)))

(defn run-length-encode
  "encodes a string with run-length-encoding"
  [plain-text]
  (->> (partition-by identity plain-text)
       (map encode-part)
       join))

(defn- decode-part [[_ number letter]]
  (if (empty? number)
    letter
    (join
     (repeat (Integer/parseInt number) letter))))

(defn run-length-decode
  "decodes a run-length-encoded string"
  [cipher-text]
  (->> cipher-text
       (re-seq #"([0-9]+)?([a-zA-Z ])")
       (map decode-part)
       join))

