(ns run-length-encoding
  (:require [clojure.string :refer [join]]))

(defn one? [n]
  (= n 1))
(defn digit? [n] (Character/isDigit n))
(defn letter? [n] (Character/isLetter n))
(defn encode-part [[letter n]]
  (str (if  (one? n) "" n) letter))

(defn run-length-encode
  "encodes a string with run-length-encoding"
  [plain-text]
  (->> (partition-by identity plain-text)
       (map frequencies)
       (into [] cat)
       (map encode-part)
       join))


(defn run-length-decode
  "decodes a run-length-encoded string"
  [cipher-text]
  (loop [start cipher-text acc []]
    (if (empty? start)
      (join (map (partial apply str) acc))
      (let [n (take-while digit? start)
            digit-count (count n)
            c (take 1 (drop digit-count start))
            letter-count (count c)
            nxt (drop (+ digit-count letter-count) start)
            num (Integer/parseInt (if (empty? n) "1" (apply str n)))
            letter (apply str c)]
        (recur nxt
               (conj acc (repeat num letter)))))))
