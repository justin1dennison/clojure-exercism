(ns robot-simulator
  (:require [clojure.set :refer [map-invert]]))

(defn robot [coords bearing]
  {:coordinates coords :bearing bearing})

(def turn-right
  {:east :south
   :south :west
   :west :north
   :north :east})

(def turn-left (map-invert turn-right))

(defn- advance [robot]
  (let [{direction :bearing} robot]
    (case direction
      :east  (update-in robot [:coordinates :x] inc)
      :west  (update-in robot [:coordinates :x] dec)
      :north (update-in robot [:coordinates :y] inc)
      :south (update-in robot [:coordinates :y] dec))))

(defn- step [robot action]
  (case action
    \L  (update robot :bearing turn-left)
    \R  (update robot :bearing turn-right)
    \A  (advance robot)))

(defn simulate [actions rbt]
  (reduce step rbt actions))








