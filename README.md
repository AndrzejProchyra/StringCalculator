# StringCalculator

## Open Questions

At the end we tried to refactor but we ended up implementing a new feature instead.
"Obviously" if we are intending to refactor we should only do that, but how would we have prevented adding the feature?

## Retros

## 22/09/2025

1. How did that feel?
    - Positive
    - Out of flow
    - Productive
2. What did we do that we want to make sure we do more of?
    - Rob: Created a routine to help him with the flow. Continue iterating on it.
    - Announcing talker/typist at the start of a cycle
    - Taking account of each other's preferences
3. What can we try next time?
    - Andrzej: take small notes as we go, so I can better reflect on what happened in the retro
    - Create a skeleton project to start a kata from
    - Balance flow with experimentation - we each keep an "inbox" and after each cycle we take a minute to discuss
      anything we wrote down

Next time

- Continue with the String Calculator kata

## 29/09/2025

1. How did that feel?
    - Andrzej: Good and productive
    - Unsure of TDD flow
    - Rob: Good learning opportunities
2. What did we do that we want to make sure we do more of?
    - Deferring side quests and writing things down
    - Some implicit things: switching over, communicating well
    - Finding the middle ground between flow and experimentation, we are definitely improving at this
      2.5 What isn't working
    - Running out of time, is that normal?
    - Forgetting refactoring
3. What can we try next time?
    - Keep an inbox
    - Switching on green or ping pong?
4. What we experimented with:
    - mob.sh - Required some setup, but worked well with using the URL so we could both hear

## 06/10/2025

- Andrzej: Felt good again, making progress
- Rob: Feeling frustrated/unsure, it is hard to "slow" down
- We tried ping ponging this time
- Created an inbox

## 13/10/2025

- still feel overwhelmed by where/when to start "simple" refactoring
- liked the Rob's Strong Style Ping-Pong (TM)
- also liked the strong style ping-pong since it helps us both practice navigating
- we need to "try" more than "talk" because we have tests!!!
- it is good to be able to bring things we've learned and practice them in a "safe sandbox"

## 20/10/2025

- Using Multi Player Chess Clock (https://multiplayerchessclock.com/game/39stoxz2khq8oolv)
    - Talker is the one "playing"
- TODO: Write checklist for starting a pairing session
- Terminology:
    - Typer, Talker
- We both had somewhat equal time from last time with 30~ minutes
- I think Andrzej as the talker during refactoring was very helpful (Rob)
- The clock helped us be more aware that Andrzej talked for 1 hour 20 minutes today, Rob didn't talk
- Should maybe consider resetting clock each time, if we use clock
- We shifted away from timer to strong style ping pong but today we did a lot of refactoring
- Ping pong is meant for red green refactor, but since we were staying in refactor, what to do?
- Is the root cause that we didn't refactor enough earlier?
- Need to pay attention to when we are shifting into refactoring so that we can pivot

## 07/11/2025

- Discussed and implemented step 8 in Java!
- Next time we will revert and try to do it again
- we think this is the observer pattern but need to refine language (subject/observer vs publish/subscribe)

## 15/11/2025

Retro:

- How did it feel?
    - Good
- What do we want to do more of?
    - Side quests are good! We learn something from each of them
    - Defer some side quests that would be better to do later — write them down to have confidence that you won't forget
      them
- What can we try?
    - Andrzej will join the JBrains Experience to see how it works

## 21/11/2025

Retro:

- Rob felt that he was interrupting the navigator a lot and asking too many questions
- Andrzej felt that this was OK because he didn't have a good idea where to go and it helped him think.
- Learning when to go off on a tangent and when to use the inbox is a valuable skill
- What can we try?
    - Maybe we had too long a preamble?
    - Add more structure so that we spend more time coding

Notes:

- We tried to implement the long delimiters requirement but the code is not open and indexes into the input string with
  hard-coded values and constructs a regex assuming a single-character delimiter. We therefore need to refactor to
  generalise this. BUT SEE THE OPEN QUESTION - ask JB?

## 24/11/2025

- Got started quicker, not too many tangents, Andrzej feels that he is imposing his ideas too much
- Rob practiced Woody Zuill type listening + inbox and didn't feel there was imposition
- Also tried out keeping a failing test to ensure we didn't accidently implement behavior, but it felt weird
    - It was an attempt at a feedback loop of only changing behavior and not going too far
- What can we try next?
    - Andrzej wants to try writing stuff out

## 28/11/2025

### What's helping?

- Liked mob.sh, with room, and with 10 minute+ switching
- Rob likes the integration between mob.sh and the room, but dislike that the timer doesn't as easily show real time
  that we did (like the chess clock did)
- Small refactors help to keep momentum

### What obstacles are there? (intentionally not saying slow)

- Regex

### What can we try?

- Following the next step that is in the Inbox -> Current Task -> next step
- Disciplined breaks (10 minutes, every hour)

## 2/12/2025

### What's helping?
- I liked the disciplined break (Andrzej)

### What obstacles are there?
- We are losing some faith in mob.sh and losing commits! 😱
- I am still derailing things, instead of writing them down - Andrzej
- I am being a runaway driver... - Andrzej

### What can we try?
- Try a different kata? - Andrzej

## 9/12/2025

### Gut feeling
- Still useful and we discuss interesting things
- Frustrating (about the kata)
- More positive

### What's helping?
- mob.sh + setting a goal
- regular cadence
- openness +1
- having a routine (Rob)
- squashing the tiny commits helped Rob feel better

### What obstacles are there?
- Regex

### What can we try?
- Read the prime directive of retros before the retro
- Use the next time to try to actually finish this, and then drop it regardless