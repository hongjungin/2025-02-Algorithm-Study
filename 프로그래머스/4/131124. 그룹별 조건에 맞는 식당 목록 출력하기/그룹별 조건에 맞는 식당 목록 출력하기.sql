-- 리뷰를 가장 많이 작성한 회원의 리뷰를 조회
-- 회원 이름, 리뷰 텍스트, 리뷰 작성일 출력

-- 리뷰 작성일 기준 오름차순
-- 같다면 리뷰 텍스트 기준 오름 차순
SELECT p.MEMBER_NAME, r.REVIEW_TEXT, 	r.REVIEW_DATE
FROM REST_REVIEW r
INNER JOIN MEMBER_PROFILE p
ON r.MEMBER_ID = p.MEMBER_ID
WHERE r.MEMBER_ID IN (
    SELECT MEMBER_ID
    FROM (
    SELECT MEMBER_ID
    FROM REST_REVIEW
    GROUP BY MEMBER_ID
    ORDER BY COUNT(*) DESC
    LIMIT 1) as winner
)
ORDER BY REVIEW_DATE, REVIEW_TEXT;