(ns run-length-encoding
  (:require [clojure.string :refer [join]]))

(defn one? [n]
  (= n 1))

(defn run-length-encode
  "encodes a string with run-length-encoding"
  [plain-text]
  (if (empty? plain-text)
    plain-text
    (let [parts (partition-by identity plain-text)
          counts (into [] cat (map frequencies parts))]
      (join
       (map
        (fn [[letter n]]
          (str (if  (one? n) "" n) letter))
        counts)))))

(defn digit? [n] (Character/isDigit n))
(defn letter? [n] (Character/isLetter n))

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
