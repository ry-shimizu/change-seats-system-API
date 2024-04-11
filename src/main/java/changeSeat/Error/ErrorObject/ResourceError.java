package changeSeat.Error.ErrorObject;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ResourceError {
    private final String errorMessage;
}
