(ns gigasecond
  (:require [clj-time.core :as t]))

(defn flip [f]
  (fn [& xs]
    (apply f (reverse xs))))

(def plus (flip t/plus))
(def gigaseconds (t/seconds 1e9))

(defn from [y m d] 
   (->> (t/date-time y m d) 
        (plus gigaseconds)
        ((juxt t/year t/month t/day))))
    
    
