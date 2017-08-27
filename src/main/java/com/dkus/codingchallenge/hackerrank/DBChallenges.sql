-- https://www.hackerrank.com/challenges/interviews/problem
SELECT ct.contest_id, ct.hacker_id, ct.name, SUM(cha.ts), SUM(cha.tas), SUM(cha.tv), SUM(cha.tuv)
FROM contests ct
INNER JOIN colleges cl
ON ct.contest_id = cl.contest_id
INNER JOIN (
  SELECT ch.college_id, COALESCE(SUM(st.ts),0) ts, COALESCE(SUM(st.tas),0) tas, COALESCE(SUM(vs.tv),0) tv, COALESCE(SUM(vs.tuv),0) tuv
  FROM challenges ch
  LEFT JOIN (
    SELECT challenge_id, SUM(vsl.total_views) tv, SUM(vsl.total_unique_views) tuv
    FROM view_stats vsl
    GROUP BY challenge_id
  ) vs
  ON ch.challenge_id = vs.challenge_id
  LEFT JOIN (
    SELECT challenge_id, SUM(stl.total_submissions) ts, SUM(stl.total_accepted_submissions) tas
    FROM submission_stats stl
    GROUP BY challenge_id
  ) st
  ON ch.challenge_id = st.challenge_id
  GROUP BY ch.college_id
  HAVING COALESCE(SUM(vs.tv),0) + COALESCE(SUM(vs.tuv),0) + COALESCE(SUM(st.ts),0) + COALESCE(SUM(st.tas),0) <> 0
) cha
ON cl.college_id = cha.college_id
GROUP BY ct.contest_id, ct.hacker_id, ct.name
ORDER BY ct.contest_id