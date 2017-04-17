(ns testing.input
  (:require [play-clj.core :refer :all]))

(defn move
  [entity direction]
  (case direction
    :down (update entity :y dec)
    :up (update entity :y inc)
    :left (update entity :x dec)
    :right (update entity :x inc)
    nil))
