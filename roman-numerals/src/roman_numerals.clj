(ns roman-numerals
  (:require [clojure.string :as s]))

(def substitutions [ 
           ["IIIII" "V"]
           ["VV" "X"]
           ["XXXXX" "L"]
           ["LL" "C"]
           ["CCCCC" "D"]
           ["DD" "M"]
           ["IIII" "IV"]
           ["VIV" "IX"]
           ["XXXX" "XL"]
           ["LXL" "XC"]
           ["CCCC" "CD"]
           ["DCD" "CM"]
           ])

(defn reducer [n [from to]]
  (s/replace n from to))

(defn numerals [n]
  (reduce
   reducer
   (s/join (take n (repeat "I")))
   substitutions))
