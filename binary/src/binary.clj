(ns binary
  (:require [clojure.set :refer [subset?]]))

(defn- transform [n]
  "Shifts a character representing a digit to the corresponding value."
  (- (int n) 48))

(defn- power [base exponent]
  "base to the power exponent (base ^ exponent)"
  (->> (repeat base)
       (take exponent)
       (reduce * 1)))

(defn- valid-bits? [n]
  "Determines whether a string is valid bits"
  (subset? (set n) #{\1 \0}))

(defn to-decimal [in]
  (if (not (valid-bits? in))
   0 
    (->> in
         (reverse)
         (map transform)
         (map-indexed #(* %2 (power 2 %1)))
         (reduce + 0))))

  
