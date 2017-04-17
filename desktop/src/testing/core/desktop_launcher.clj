(ns testing.core.desktop-launcher
  (:require [testing.core :as game])
  (:import [com.badlogic.gdx.backends.lwjgl LwjglApplication]
           [org.lwjgl.input Keyboard])
  (:gen-class))

(defn -main
  []
  (LwjglApplication. game/testing-game "Clojure's Rampage" 800 600)
  (Keyboard/enableRepeatEvents true))
