(ns gigasecond
  (:require [clj-time.core :as t]))

(def seconds 1000000000)

(defn from [year month day] 
  (let [date (t/date-time year month day)
        next-date (t/plus date (t/seconds seconds))        
        ]
    [
     (t/year next-date) 
     (t/month next-date) 
     (t/day next-date)]))
    
    
