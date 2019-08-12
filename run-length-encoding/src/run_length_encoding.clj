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


(defn decode-part [g]
  (let [letter (last g)
        number (join "" (drop-last g))]
    (if (empty? number)
      (str letter)
      (join
       (repeat (Integer/parseInt number) letter)))))

(defn run-length-decode
  "decodes a run-length-encoded string"
  [cipher-text]
  (->> cipher-text
       (re-seq #"[0-9]{0,2}[a-zA-Z ]")
       (map decode-part)
       (join "")))



